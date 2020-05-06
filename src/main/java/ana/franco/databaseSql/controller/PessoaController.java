package ana.franco.databaseSql.controller;


import ana.franco.databaseSql.model.PessoaEntity;
import ana.franco.databaseSql.Repository.PessoaRepository;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class  PessoaController {


    @Autowired
    private PessoaRepository  pessoaRepository;

    @GetMapping
    public ResponseEntity<List<PessoaEntity>> findAll (){  // get
        return new ResponseEntity<List<PessoaEntity>>(
                (List<PessoaEntity>) this.pessoaRepository.findAll(),
                new HttpHeaders(), HttpStatus.OK);//error 404
    }


    @GetMapping(path = "/{id}")
    public ResponseEntity<PessoaEntity> findById(@PathVariable ("id") long id) {
        if(this.pessoaRepository.findById(id).isPresent()){
            return new ResponseEntity<PessoaEntity>(
                    this.pessoaRepository.findById(id).get(),
                    new HttpHeaders(),
                    HttpStatus.OK);

        }
        return new ResponseEntity<PessoaEntity>(HttpStatus.NOT_FOUND);
    }


    public ResponseEntity<PessoaEntity> cadastrar (@RequestBody PessoaEntity pessoaEntity) {
        return new ResponseEntity<PessoaEntity> (
                this.pessoaRepository.save(pessoaEntity),
                new HttpHeaders(),
                HttpStatus.CREATED
        );

    }
    
    @PutMapping(value = "/{id}")
    public ResponseEntity<PessoaEntity> atualizar (@PathVariable("id") long id,
                                                        @RequestBody PessoaEntity pessoaEntity) throws Exception {

        if(id == 0 || !this.pessoaRepository.existsById(id)){
            throw  new Exception("Código não encontrado ou inexistente!");

        }
        return new ResponseEntity<PessoaEntity>(
                this.pessoaRepository.save(pessoaEntity),
                new HttpHeaders(),
                HttpStatus.OK);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<PessoaEntity> deletar (@PathVariable("id") long id ){
        this.pessoaRepository.deleteById(id);
        return new ResponseEntity<PessoaEntity>(new HttpHeaders(), HttpStatus.OK);
    }

}