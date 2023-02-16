package ProyectoIntegradorEQ5.demo.service;

import ProyectoIntegradorEQ5.demo.Exceptions.ResourseNotFoundException;
import ProyectoIntegradorEQ5.demo.entidades.Categoria;
import ProyectoIntegradorEQ5.demo.repositorios.CategoriasRepository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;
@AllArgsConstructor
public class CategoriaService {



        private final CategoriasRepository repository;



    public void agregar(Categoria categoria) throws ResourseNotFoundException {
            repository.save(categoria);

        }

        public List<Categoria> listar()  {
            return repository.findAll();
        }

        public void modificar(Categoria categoria){
            repository.save(categoria);
        }

        public void eliminar(int id) throws ResourseNotFoundException {
            repository.findById(id).orElseThrow(()-> new ResourseNotFoundException("La categoria con id: " + id +" no existe en la base de datos"));
            repository.deleteById(id);
        }

        public Optional<Categoria> getById (int id){
            return repository.findById(id);
        }


}
