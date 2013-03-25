package my.spitterP.mainP;

import java.util.List;

import my.spitterP.mainP.Spitter;




public interface SpitterDao {
  void addSpitter(Spitter spitter);

  void saveSpitter(Spitter spitter);

  Spitter getSpitterById(long id);

  List<Spittle> getRecentSpittle();
  
  void saveSpittle(Spittle spittle);
  
  List<Spittle> getSpittlesForSpitter(Spitter spitter);

  Spitter getSpitterByUsername(String username);
  
  void deleteSpittle(long id);
  
  Spittle getSpittleById(long id);
  
  List<Spitter> findAllSpitters();
}
