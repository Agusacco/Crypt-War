package sas.crypt.war;

import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;
import net.arikia.dev.drpc.DiscordUser;
import net.arikia.dev.drpc.callbacks.ReadyCallback;

public class Discord {

	private boolean running = true;
	private long created = 0;
	
	public void start() {
		
		this.created = System.currentTimeMillis();
		
		DiscordEventHandlers handlers = new DiscordEventHandlers.Builder().setReadyEventHandler((user) -> {
			
			System.out.println("Welcome " + user.username + "#" + user.discriminator + "!");
			
			    
		}).build();
		
		DiscordRPC.discordInitialize("756314178196602992", handlers, true);
		
		new Thread("Discord RPC Callback") {
			
			@Override
			public void run() {
				
				while(running) {
					
					DiscordRPC.discordRunCallbacks();
					
				}
				
			}
			
		}.start();
		
	}
	
	public void shutdown() {
		
		running = false;
		DiscordRPC.discordShutdown();
		
	}
	
	public void update(String firstLine, String secondLine, String joinSecret, String spectateSecret) {
		
		DiscordRichPresence.Builder b = new DiscordRichPresence.Builder(secondLine);
		b.setBigImage("prueba2", "");
		b.setDetails(firstLine);
		b.setStartTimestamps(created);
		
		DiscordRPC.discordUpdatePresence(b.build());
		
	}
	
}
