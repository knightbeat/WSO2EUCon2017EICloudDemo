# WSO2EUCon2017EICloudDemo

1. Deploy 2 microservices in the `microservices` directory on Public Cloud.
    * Run and check with http://{host}/risk-events/velocity?velocity=80&outerElevation=2&curvature=1
    * and http://{host}/delay-checker/sensor-event?trainID=EST182&departureTime=0510&sensorPost=KET-035
2. Deploy `WSO2EUCon2017CARProject_1.0.0.car` file on Public cloud.
    * Please check the `Endpoint` URLs after uploading and fix accordingly
    * Eclipse project is also available at `eclipse-projects` directory
    * Run and check POST http://{host}:8280/railway-sensor-data/events with
        - `{"WindowID":"F4D9EAB9020F79FA221509886986292","event":{"SensorPost":"KET-008","TrainID":"EM-HST100","DepartureTime":"0543","Velocity":"80.8KMH","OuterElevation":"2","Curvature":"1"}}`
        - This should insert a record to the Database (Check Data Service Definition for Database URL & params)
        - Status update on https://twitter.com/WSO2EUTrains
3.  Deploy `WSO2EUCon2017CAROnPremProject_1.0.0.car` file on on-premise instance.
    * Please check the `Endpoint` URLs after uploading and fix accordingly
    * Eclipse project is also available at `eclipse-projects` directory
    * Copy `KET-TRN-SNSR-DATA-0500_0600.csv` file to the `in` directory of the InboundEndpoint
        - This should insert a few records to the Database (Check Data Service Definition for Database URL & params)
        - Status updates on https://twitter.com/WSO2EUTrains
