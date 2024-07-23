package com.example.demo.grpc;

import com.example.service.grpc.HelloWorldServiceGrpc;
import com.example.service.grpc.HelloWorldServiceGrpc.HelloWorldServiceBlockingStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.service.grpc.HelloRequest;
import com.example.service.grpc.HelloResponse;

@RestController
public class GrpcController {

  // @Autowired
  // GrpcClient grpcClient;
  // private HelloWorldServiceGrpc.HelloWorldServiceBlockingStub stub;

  @GetMapping("/user")
  public String user() {
    // return "Hello User";

    ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9091)
        .usePlaintext()
        .build();
    //
    final HelloWorldServiceBlockingStub stub = HelloWorldServiceGrpc.newBlockingStub(channel);
    HelloResponse helloResponse = stub.sayHello(HelloRequest.newBuilder().setName("Rohan Kumar Mainali").build());
    return helloResponse.getMessage();
    //
    // HelloResponse helloResponse =
    // stub.sayHello(HelloRequest.newBuilder().setName("Rohan Kumar
    // Mainali").build());
    // System.out.println("Response " + helloResponse.getMessage());
    // return helloResponse.getMessage();
  }

}
