Whilst the branch name has List, this ended up taking a bit of detour.

Problem:

Sending query result as is, which includes nested classes
However, some classes contain confidential info such as user hashed password

Previous Solution:
To only send the necessary information, InviteService is customizing the invite details

The logic is, InviteService converts findById result into JSON
Then parses JSON to fit into CustomInvite class, which includes only needed part for the front end.

Questioning the logic:
Why query the result, convert to json, then filter it? Why not just query the result with parts only needed then convert to Json once?

Solution was selecting the specific columns from the DB

here's the answer:
https://stackoverflow.com/questions/22007341/spring-jpa-selecting-specific-columns

Two solutions 
1) create a new instance in the JPQL
solution for a different problem that hints the answer:
@Query("select new com.foo.bar.entity.Document(d.docId, d.filename) from Document d where d.filterCol = ?1")
List<Document> findDocumentsForListing(String filterValue);

2) use interface (chosen method here)

addition to ff085b9 branch:
The solution implemented to getOne Invitation is extended to getAll invitations, now returning an array of invitation objects

addition to 11ad343 branch:
wgl request route completed, but for only single invite, next list of invites

addition to 0305336 branch:
wgl request route completed for list of invites