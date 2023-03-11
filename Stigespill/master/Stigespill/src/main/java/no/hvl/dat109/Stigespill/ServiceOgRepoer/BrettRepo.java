package no.hvl.dat109.Stigespill.ServiceOgRepoer;


import org.springframework.data.jpa.repository.JpaRepository;

import no.hvl.dat109.Stigespill.Model.Rute;


public interface BrettRepo extends JpaRepository<Rute, Integer> {
}
