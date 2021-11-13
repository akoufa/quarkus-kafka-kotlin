package org.acme

import io.smallrye.reactive.messaging.kafka.Record
import org.eclipse.microprofile.reactive.messaging.Incoming
import javax.enterprise.context.ApplicationScoped
import javax.ws.rs.Consumes
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@ApplicationScoped
@Path("/orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class OrdersService {

    @POST
    @Path("/")
    suspend fun createOrder(order: Order) {
        println(order.id)
    }

    @Incoming("order-in")
    suspend fun consumeOrderEvents(orderRecord: Record<String, Order>) {
        val order = orderRecord.value()
        println(order.id)
    }
}