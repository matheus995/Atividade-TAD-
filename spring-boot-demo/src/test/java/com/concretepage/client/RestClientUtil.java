package com.concretepage.client;

import java.net.URI;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.concretepage.entity.Usuario;

public class RestClientUtil {
    public void getUsuarioByIdDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/usuario/{id}";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Usuario> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Usuario.class, 1);
        Usuario usuario = responseEntity.getBody();
        System.out.println("Id:"+usuario.getId()+", Nome:"+usuario.getNome()
                 +", E-mail:"+usuario.getEmail());      
    }
	public void getAllUsuariosDemo() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/usuarios";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Usuario[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Usuario[].class);
        Usuario[] usuarios = responseEntity.getBody();
        for(Usuario usuario : usuarios) {
              System.out.println("Id:"+usuario.getId()+", Title:"+usuario.getNome()
                      +", Category: "+usuario.getEmail());
        }
    }
    public void addUsuarioDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/usuario";
	    Usuario objUsuario = new Usuario();
	    objUsuario.setNome("Spring REST Security using Hibernate");
	    objUsuario.setEmail("Spring");
        HttpEntity<Usuario> requestEntity = new HttpEntity<Usuario>(objUsuario, headers);
        URI uri = restTemplate.postForLocation(url, requestEntity);
        System.out.println(uri.getPath());    	
    }
    public void updateUsuarioDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/usuario";
	    Usuario objUsuario = new Usuario();
	    objUsuario.setId(1);
	    objUsuario.setNome("Update:Java Concurrency");
	    objUsuario.setEmail("Java");
        HttpEntity<Usuario> requestEntity = new HttpEntity<Usuario>(objUsuario, headers);
        restTemplate.put(url, requestEntity);
    }
    public void deleteUsuarioDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/usuario/{id}";
        HttpEntity<Usuario> requestEntity = new HttpEntity<Usuario>(headers);
        restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Void.class, 4);        
    }
    public static void main(String args[]) {
    	RestClientUtil util = new RestClientUtil();
        //util.getArticleByIdDemo();
    	util.getAllUsuariosDemo();
    	//util.addArticleDemo();
    	//util.updateArticleDemo();
    	//util.deleteArticleDemo();
    }    
}
