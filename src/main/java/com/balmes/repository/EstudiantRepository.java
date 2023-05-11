package com.balmes.repository;

import com.balmes.model.Curs;
import com.balmes.model.Estudiant;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class EstudiantRepository implements CrudRepository<Estudiant> {

  public List<Estudiant> findAll() {
    // TODO Auto-generated method stub
    List<Estudiant> estudiantList = new ArrayList<>();
    CursRepository cursRepository = new CursRepository();
    final List<Curs> allCursos = cursRepository.findAll();
    estudiantList.add(new Estudiant(1, "David", "Rosalia", allCursos.get(1)));
    estudiantList.add(new Estudiant(2, "Aranu", "Betis", allCursos.get(0)));
    estudiantList.add(new Estudiant(3, "Alexia", "Cumelles", allCursos.get(1)));
    estudiantList.add(new Estudiant(4, "Victoria", "Chacona", allCursos.get(1)));
    return estudiantList;
  }

  public List<Estudiant> getEstudiantsperCurs(int cursId) {
    List<Estudiant> estudiantsPerCurs = new ArrayList<>();

    List<Estudiant> estudiantList = findAll();
    for (Estudiant estudiant : estudiantList) {
      if (estudiant.getCurs().getCursId() == cursId) {
        estudiantsPerCurs.add(estudiant);
      }
    }

    return estudiantsPerCurs;

  }
}
