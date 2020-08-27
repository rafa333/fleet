package com.everis.training.fleet.business.common;

import com.everis.training.fleet.business.fleet.boundary.VehicleResource;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath(FleetApplication.REST_PATH)
public class FleetApplication extends ResourceConfig {
  public static final String REST_PATH = "rs";

  public FleetApplication() {
    packages(VehicleResource.class.getPackage().getName());
  }
}
