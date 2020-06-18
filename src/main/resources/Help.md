### how to add db password in the .env file?

go to .env level and then export  the variables to environment
```export $(cat .env | xargs)```
then run the maven run command on the terminal
```mvn spring-boot:run```


