package com.antoniojnavarro.odilo.tasks;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.antoniojnavarro.odilo.OdiloApplication;

@Service("tareasProgramadas")
public class TareasProgramadas {
	private static final Logger logger = LoggerFactory.getLogger(OdiloApplication.class);

//	@Autowired
//	TaskScheduler taskScheduler;
//
//	ScheduledFuture<?> scheduledFuture;
//
//	@Value("${fixed.delay}")
//	private long fixedDelay;

	@Async
	@Scheduled(initialDelayString = "${initial.delay}", fixedDelayString = "${fixed.delay}")
	public void mostrarMensajeTest() {
		logger.info("Test job executed at " + new Date());
//		scheduledFuture = taskScheduler.schedule(pintarFecha(), new Date());

	}

//	private Runnable pintarFecha() {
//		return () -> logger.info("Test job 1 executed at " + new Date());
//	}
}
