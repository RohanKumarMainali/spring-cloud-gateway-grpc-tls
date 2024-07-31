package com.grpc_server.demo.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import com.example.service.grpc.HelloRequest;
import com.example.service.grpc.HelloResponse;
import com.example.service.grpc.HelloWorldServiceGrpc;
import com.example.service.grpc.HelloWorldServiceGrpc.HelloWorldServiceBlockingStub;

public class Client {
  public static void main(String[] args) {

    // ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9091)
    // .usePlaintext()
    // .build();
    //
    // HelloWorldServiceBlockingStub stub =
    // HelloWorldServiceGrpc.newBlockingStub(channel);
    //
    // HelloResponse helloResponse =
    // stub.sayHello(HelloRequest.newBuilder().setName("Rohan Kumar
    // Mainali").build());
    // System.out.println("Response " + helloResponse.getMessage());

  }
}
