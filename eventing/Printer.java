package eventing;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;

public class Printer extends RouteBuilder {
    public void configure() {

        from("knative:channel/messages")
                .unmarshal().json(JsonLibrary.Jackson)
                .transform().simple("${body[value][joke]}")
                .log("${body}");

    }

}