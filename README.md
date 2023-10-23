# dynamicBillingSystem

## URL da API disponível

### Local
API: http://localhost:8080/dynamicBilling


### Run Database
docker run --name billing-db -p 5432:5432 -e POSTEGRES_DB=billing -e POSTEGRES_USER=admin -e POSTEGRES_PASSWORD=admin -d postgres:10-alpine


### Stop Database
docker stop billing-db
