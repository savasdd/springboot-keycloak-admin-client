keyloack start on docker images
keyloack start url this http://localhost:8081/auth/
login keyloack with admin user and create etkb-sinav realm
open clients and create sinav-backend client after that open rols sekment and create SINAV_ROL to client
open users and create a user that name is savas.dede and open rols mapping to give SINAV_ROL the backend
use postman to give token:
Type: Auth2.0
Header: Bearer
Grant Type: Password
Access URL: http://localhost:8081/auth/realms/etkb-sinav/protocol/openid-connect/token
Client ID: sinav-backend
User: savas.dede

the end process token and use token to requests.



