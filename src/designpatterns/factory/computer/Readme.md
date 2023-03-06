# Abstract factory 
    - You will have one more abstraction to the factory, so that client can pass the respective flavours of abstraction factory to the factory client
    - Factory distribution client will not have any type checks on params to select the respective factory and it would scale well
# Example
        AbstractComputerFactory pcFactory=new PCFactory(8,512);
        ComputerMasterFactory.getComputer(pcFactory).getComputer();

        AbstractComputerFactory serverFactory=new ServerFactory(16,1024);
        ComputerMasterFactory.getComputer(serverFactory).getComputer();

        