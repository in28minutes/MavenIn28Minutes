package com.in28minutes.example.layering.data.stub;

import org.springframework.stereotype.Component;

import com.in28minutes.example.layering.data.api.client.ClientDO;
import com.in28minutes.example.layering.model.api.client.Client;

@Component
public class ClientDOStub implements ClientDO {

	@Override
	public Client getClientDetails(long clientId) {
		return null;
	}

	@Override
	public void saveClient(Client client) {
		
	}
}
