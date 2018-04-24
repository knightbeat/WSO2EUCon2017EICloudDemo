# Risk-events analyser microservice

The velocity of a train is provided against the curvature and outer elevation of a particular curve on a rail track. Then the service is supposed to provide a response similar to,

`{"risk":true,"requiredSpeed":84.51542547285166,"maximumSpeed":200.0}`

## How to run the service

`java -Dhttp.port=8082 -jar WSO2EUTrainsRiskEventsChecker-2.4.3-SNAPSHOT.jar`

## How to try the service

http://localhost:8082/risk-events/velocity?velocity=80&outerElevation=2&curvature=1
