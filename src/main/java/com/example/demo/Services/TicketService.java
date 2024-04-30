package com.example.demo.Services;

import java.util.Date;
import java.util.Optional;

import com.example.demo.exceptions.InvalidGateException;
import com.example.demo.models.Gate;
import com.example.demo.models.Ticket;
import com.example.demo.models.VehicleType;
import com.example.demo.repos.GateRepository;

public class TicketService
{
    private GateRepository gateRepository;

    public TicketService(GateRepository gateRepository) {
        this.gateRepository = gateRepository;
    }

    public Ticket issueTicket(Long gateId, String vehicleNumber, VehicleType vehicleType, String ownerName) throws InvalidGateException {
        Ticket ticket = new Ticket();
        ticket.setEntryTime(new Date());

        Optional<Gate> optionalGate = gateRepository.findById(gateId);

        if (optionalGate.isEmpty()) {
            throw new InvalidGateException("Invalid gate Id");
        }

        Gate gate = optionalGate.get();
        ticket.setGeneratedAt(gate);
        ticket.setGeneratedBy(gate.getOperator());
        return null;
    }
}

