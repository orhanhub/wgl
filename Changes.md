customSerializer, changes to a0e8ba5 version:

#Problem:

When the "/invite/{id}"  endpoint was hit, I was just sending the raw ManyToOne relationship as nested Json

Nested Json included account id, and password which was confidential.

# Solution:

The solution was a custom Json Deserializer and this version implemented such for the aforementioned endpoint only

Controller requested getonebyid from invite service

Previously sending the inviteRepo query as is, now intercepted by ObjectMapper before sending.

Invite service was calling a custom serialization (in this case InviteSerializer class) module and registering with ObjectMapper

Custom serializer was flattening the json and filtering for the only needed content and returning the edited json



