package org.sid.web;

import java.util.List;

import org.sid.dao.ActualiteRepository;
import org.sid.entities.Actualite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class ActualiteRestService {
 
	@Autowired
	private ActualiteRepository actualiteRepository;
	
	@RequestMapping(value="/actualites",method=RequestMethod.GET)
	public List<Actualite> getActualites(){
		return actualiteRepository.findAll();
	}
	@RequestMapping(value="/actualites/{id}",method=RequestMethod.GET)
	public Actualite getActualite(@PathVariable Long id){
		return actualiteRepository.findOne(id);
	}
	@RequestMapping(value="/actualites",method=RequestMethod.POST)
	public Actualite save(@RequestBody Actualite actualite){
		return actualiteRepository.save(actualite);
	}
	@RequestMapping(value="/actualites/{id}",method=RequestMethod.PUT)
	public Actualite update(@RequestBody Actualite actualite,@PathVariable Long id){
		actualite.setId(id);
		return actualiteRepository.save(actualite);
	}
	@RequestMapping(value="/actualites/{id}",method=RequestMethod.DELETE)
	public boolean delete(@PathVariable Long id){
		Actualite actualite=actualiteRepository.findOne(id);
		if(actualite!=null){
			actualiteRepository.delete(id);
			return true;
		}	
		else 
			return false;
	}
	@RequestMapping(value="/chercher",method=RequestMethod.GET)
	public Page<Actualite> search(@RequestParam(name="titre",defaultValue="") String titre,@RequestParam(name="page",defaultValue="0") int page,@RequestParam(name="size",defaultValue="4") int size){
		return actualiteRepository.rechercher("%"+titre+"%", new PageRequest(page, size));
	}
}
