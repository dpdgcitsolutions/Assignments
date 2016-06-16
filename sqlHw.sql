Part I
1) How many copies of the book titled The Lost Tribe are owned by the
library branch whose name is "Sharpstown"?

SELECT noOfCopies
FROM book_copies as bkcp
JOIN book ON bkcp.bookId = book.bookId
JOIN library_branch AS lib ON bkcp.branchId = lib.branchId
WHERE book.title = "The Lost Tribe" AND lib.branchName = "Sharpstown";

2) How many copies of the book titled The Lost Tribe are owned by each
 library branch?

SELECT noOfCopies, lib.branchName
FROM book_copies as bkcp
JOIN book ON bkcp.bookId = book.bookId
JOIN library_branch AS lib ON bkcp.branchId = lib.branchId
WHERE book.title = "The Lost Tribe";

3) Retrieve the names of all borrowers who do not have any books
checked out

SELECT	DISTINCT bo.name
FROM 	borrower AS bo
WHERE	bo.cardId NOT EXISTS
		(
			SELECT	1
			FROM 	book_loans AS loans
			WHERE	bo.cardId = loans.bookId
		);

4) For each book that is loaned out from the "Sharpstown" branch and
whose DueDate is today, retrieve the book title, the borrower's name,
and the borrower's address.

SELECT	book.title, bo.name, bo.address
FROM 	book
JOIN	book_loans AS loans ON loans.bookId = book.bookId
JOIN	borrower AS bo ON bo.cardId = bo.cardId
JOIN	library_branch AS lib ON lib.branchId = loans.branchId
WHERE	lib.branchName = "Sharpstown" AND loans.dueDate = CURDATE();

5) For each library branch, retrieve the branch name and the total number
of books loaned out from that branch.

SELECT	lib.branchName, COUNT(loan.bookId)
FROM	library_branch AS lib
JOIN	book_loans AS loan ON loan.branchId = lib.branchId;

6) Retrieve the names, addresses, and number of books checked out for
all borrowers who have more than five books checked out.

SELECT 	bo.name, bo.address, COUNT( DISTINCT loans.bookId )
FROM 	borrower AS bo
JOIN	book_loans AS loans ON loans.cardId = bo.cardId
GROUP BY bo.name
WHERE	COUNT(loans.bookId) > 5


7) For each book authored (or co-authored) by "Stephen King", retrieve the
title and the number of copies owned by the library branch whose name is
"Central"

SELECT	title, noOfCopies
FROM 	book
JOIN	book_copies AS bkcp ON book.bookId = bkcp.bookId
JOIN	library_branch AS lib ON lib.branchId = bkcp.branchId
JOIN	book_authors AS bkau ON bkau.bookId = book.bookId
JOIN	author ON author.authorId = bkau.authorId
WHERE	lib.branchName = "Central" AND author.authorName = "Stephen King";

Part II
8) Retrieve the names of employees in department 5 who work more than 10
hours per week on the 'ProductX' project.

SELECT	E.FNAME, E.LNAME
FROM 	EMPLOYEE AS Emp
JOIN	WORKS_ON AS Wo ON Wo.ESSN = E.SSN
JOIN	PROJECT AS P ON P.PNUMBER = Wo.PNO
WHERE	P.PNAME = "ProductX" AND Wo.Hours > 10 AND E.DNO = 5;

9) For each project, list the project name and the total hours per week
(by all employees) spent on that project.

SELECT	P.PNAME, SUM(Wo.HOURS)
FROM 	PROJECT AS P
JOIN 	WORKS_ON AS Wo ON P.PNUMBER = Wo.PNO
JOIN	EMPLOYEE AS E ON Wo.ESSN = E.SSN
GROUP BY P.PNAME;

10) Retrieve the names of employees who work on every project.
SELECT	E.FNAME, E.LNAME
FROM 	EMPLOYEE AS E
WHERE	NOT EXISTS
		(
			SELECT 	P.PNUMBER
			FROM 	PROJECT AS P
			WHERE	NOT EXISTS
				(
					SELECT	*
					FROM 	WORKS_ON AS Wo
					WHERE	P.PNUMBER = Wo.PNO AND E.SSN = Wo.ESSN
				)
		);

11) 
SELECT	E.FNAME, E.LNAME
FROM 	EMPLOYEE AS E
WHERE	NOT EXISTS
		(
			SELECT	*
			FROM 	WORKS_ON AS Wo
			WHERE	Wo.ESSN = E.SSN
		);

12)
SELECT	E.NAME, E.LNAME, E.ADDRESS
FROM 	EMPLOYEE AS E
WHERE	EXISTS
		(
			SELECT	*
			FROM 	PROJECT AS P, WORKS_ON AS Wo
			WHERE	P.PLOCATION = "Houston" AND Wo.PNO = P.PNUMBER AND Wo.ESSN = E.SSN
		)
		AND NOT EXISTS
		(
			SELECT	*
			FROM 	DEPT_LOCATIONS AS Dl
			WHERE	Dl.DNUMBER = E.DNO AND Dl.DLOCATION = "Houston"
		);

13)
SELECT	E.LNAME
FROM 	EMPLOYEE AS E
WHERE	EXISTS
		(
			SELECT	*
			FROM 	DEPARTMENT AS D
			WHERE	D.MGRSSN = E.SSN
		)
		AND NOT EXISTS
		(
			SELECT 	*
			FROM 	DEPENDENT AS DE
			WHERE 	DE.ESSN = E.SSN
		);

14)
SELECT 	E.FNAME, E.LNAME, E.SALARY
FROM 	EMPLOYEE AS E
WHERE 	E.SALARY > AVG(SALARY)
ORDER BY SALARY DESC;

15)
SELECT 	E.FNAME, E.LNAME, E.SALARY
FROM 	EMPLOYEE AS E
JOIN 	DEPARTMENT AS D ON E.DNO = E.DNUMBER
WHERE 	E.SALARY > AVG(SALARY)
ORDER BY SALARY ASC;