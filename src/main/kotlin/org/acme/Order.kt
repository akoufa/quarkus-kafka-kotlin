package org.acme

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer

class Order(val id: String = "")

class OrdersDeserializer : ObjectMapperDeserializer<Order>(Order::class.java)