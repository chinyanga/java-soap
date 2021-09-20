package za.co.discovery.assignment.francischinyanaga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import za.co.discovery.assignment.francischinyanaga.models.Planet;

@Repository
public interface PlanetRepository extends JpaRepository<Planet, Long> {

}
