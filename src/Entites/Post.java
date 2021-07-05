package Entites;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Post {
	DateFormat formato = new SimpleDateFormat ("dd/MM/yyyy");
	private Date data;
	private String titulo;
	private Integer like;
	private String legenda;
	private List<Comentario> comentario = new ArrayList<>();
	
	public Post (Date data, String titulo, Integer like, String legenda) {
		this.data=data;
		this.titulo=titulo;
		this.like=like;
		this.legenda=legenda;
	}
	public Post (Date data, String titulo, String legenda) {
		this.data= data;
		this.titulo=titulo;
		this.like=0;
		this.legenda=legenda;
	}

	public Date getData() {
		return data;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getLike() {
		return like;
	}

	public void addLike(Integer like) {
		this.like++;
	}
	public void removeLike(Integer like) {
		this.like--;
	}
	public String getLegenda() {
		return legenda;
	}
	public void setLegenda(String legenda) {
		this.legenda = legenda;
	}
	public void addComentario(Comentario comentario) {
		this.comentario.add(comentario);
	}
	public void removeComentario(Comentario comentario) {
		this.comentario.remove(comentario);
	}
	public List<Comentario> getComentario(){
		return comentario;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("\nTitulo: "+this.titulo+"\n");
		sb.append(this.like +" Likes - Data:");
		sb.append(formato.format(data)+"\n");
		sb.append("Legenda: "+this.legenda+"\n");
		sb.append("\nComentarios:\n");
		for(Comentario x : comentario) {
			sb.append(x.getComentario());
		}
		sb.append("_______________________________________________");
		return sb.toString();
		
		
	}
}
