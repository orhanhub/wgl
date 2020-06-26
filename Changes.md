Problem:

Sending query result as is, which includes nested classes
However, some classes contain confidential info such as user hashed password

Solution:
To only send the necessary information, InviteService is customizing the invite details

The logic is, InviteService converts findById result into JSON
Then parses JSON to fit into CustomInvite class, which includes only needed part for the front end.

Also:

Error Handling for findById which is an Optional class,
(De)Serialization aka (un)marshalling date format with JsonNode
 
 Would be nice:
 See todo under inviteservice 