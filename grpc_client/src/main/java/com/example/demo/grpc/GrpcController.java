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

  @GetMapping("/user")
  public String user() {
    ManagedChannel channel = ManagedChannelBuilder.forAddress("grpc-server", 80)
        .usePlaintext()
        .build();
    final HelloWorldServiceBlockingStub stub = HelloWorldServiceGrpc.newBlockingStub(channel);
    HelloResponse helloResponse = stub.sayHello(HelloRequest.newBuilder().setName("Rohan Kumar Mainali").build());
    return helloResponse.getMessage();
  }

}
