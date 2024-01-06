package org.example.model;

import com.google.protobuf.Descriptors;
import lombok.Getter;

@Getter
public class Ticket {
    private String from;
    private String to;
    private String price;
    private User user;

    public Ticket() {}

    public static TicketBuilder newBuilder() {
        return new TicketBuilder();
    }

    public static Ticket getDefaultInstance() {
        return new Ticket();
    }



    @Getter
    public static class TicketBuilder {
        private String from;
        private String to;
        private String price;
        private User user;

        public TicketBuilder() {}


        public String getFrom(String from) {
            this.from = from;
            return from;
        }

        public TicketBuilder setTo(String to) {
            this.to = to;
            return this;
        }

        public TicketBuilder setPrice(String price) {
            this.price = price;
            return this;
        }

        public TicketBuilder setUser(User user) {
            this.user = user;
            return this;
        }

        public Ticket build() {
            Ticket ticket = new Ticket();
            ticket.from = this.from;
            ticket.to = this.to;
            ticket.price = this.price;
            ticket.user = this.user;
            return ticket;
        }
    }

    // Getters and setters for Ticket class fields...
}
