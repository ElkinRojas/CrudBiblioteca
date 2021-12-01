import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class BaseDeDatos extends JFrame implements ActionListener {
	JTextArea txtSalida;
	JLabel lNombres,lEditorial,lAutor,lPrecio,lEliminar,lTituloInsertar,lTituloBorrar,lTituloActualizar,lActualizarNombres,lActualizarEditorial,lActualizarAutor,lActualizarPrecio,lIdActualizar,miNombre;
	JTextField tfNombres,tfEditorial,tfAutor,tfPrecio,tfIdEliminar,tfActualizarNombres,tfActualizarEditorial,tfActualizarAutor,tfActualizarPrecio,tfIdActualizar;
	JButton btGuardar,btEliminar,btActualizar;
	JPanel panel;
	
	//constructor
	BaseDeDatos(){
		panel = new JPanel();
		panel.setLayout(null);
		txtSalida=new JTextArea();
		 JScrollPane scroll = new JScrollPane(txtSalida);
		 scroll.setBounds(10, 10, 860, 350);
		panel.add(scroll);
		lTituloInsertar=new JLabel("INSERTAR DATO");
		lTituloInsertar.setBounds(10,380,100,20);
		panel.add(lTituloInsertar);
		
		lTituloBorrar=new JLabel("BORRAR DATO");
		lTituloBorrar.setBounds(310,380,100,20);
		panel.add(lTituloBorrar);
		lTituloActualizar=new JLabel("ACTUALIZAR DATO");
		lTituloActualizar.setBounds(500,380,200,20);
		panel.add(lTituloActualizar);
		
		lNombres=new JLabel("Nombre: ");
		lNombres.setBounds(10,410,100,20);
		panel.add(lNombres);
		tfNombres=new JTextField();
		tfNombres.setBounds(110,410,100,20);
		panel.add(tfNombres);
		
		lEditorial=new JLabel("Editorial: ");
		lEditorial.setBounds(10,440,100,20);
		panel.add(lEditorial);
		tfEditorial=new JTextField();
		tfEditorial.setBounds(110,440,100,20);
		panel.add(tfEditorial);
		
		lAutor=new JLabel("Autor: ");
		lAutor.setBounds(10,470,100,20);
		panel.add(lAutor);
		tfAutor=new JTextField();
		tfAutor.setBounds(110,470,100,20);
		panel.add(tfAutor);
		
		lPrecio=new JLabel("Precio: ");
		lPrecio.setBounds(10,500,100,20);
		panel.add(lPrecio);
		tfPrecio=new JTextField();
		tfPrecio.setBounds(110,500,100,20);
		panel.add(tfPrecio);
		
		btGuardar = new JButton("Guardar");
		
		miNombre=new JLabel("ELKIN ROJAS VILLABONA");
		miNombre.setBounds(10,560,100,20);
		panel.add(miNombre);
		
		btGuardar.setBounds(10,530,100,20);
		btGuardar.addActionListener(this);
		panel.add(btGuardar);
		lEliminar=new JLabel("ID a eliminar");
		lEliminar.setBounds(310,400,100,20);
		panel.add(lEliminar);
		tfIdEliminar=new JTextField();
		tfIdEliminar.setBounds(310,420,100,20);
		panel.add(tfIdEliminar);
		btEliminar = new JButton("Eliminar");
		btEliminar.setBounds(310,440,100,20);
		btEliminar.addActionListener(this);
		panel.add(btEliminar);
		lIdActualizar=new JLabel("ID a actualizar: ");
		lIdActualizar.setBounds(500,410,100,20);
		panel.add(lIdActualizar);
		tfIdActualizar=new JTextField();
		tfIdActualizar.setBounds(610,410,100,20);
		panel.add(tfIdActualizar);
		
		lActualizarNombres=new JLabel("Nuevo Nombre: ");
		lActualizarNombres.setBounds(500,440,100,20);
		panel.add(lActualizarNombres);
		tfActualizarNombres=new JTextField();
		tfActualizarNombres.setBounds(610,440,100,20);
		panel.add(tfActualizarNombres);
		
		lActualizarEditorial=new JLabel("Nueva editorial : ");
		lActualizarEditorial.setBounds(500,470,100,20);
		panel.add(lActualizarEditorial);
		tfActualizarEditorial=new JTextField();
		tfActualizarEditorial.setBounds(610,470,100,20);
		panel.add(tfActualizarEditorial);
		
		lActualizarAutor=new JLabel("Nuevo autor : ");
		lActualizarAutor.setBounds(500,500,100,20);
		panel.add(lActualizarAutor);
		tfActualizarAutor=new JTextField();
		tfActualizarAutor.setBounds(610,500,100,20);
		panel.add(tfActualizarAutor);
		
		lActualizarPrecio=new JLabel("Nuevo precio : ");
		lActualizarPrecio.setBounds(500,530,100,20);
		panel.add(lActualizarPrecio);
		tfActualizarPrecio=new JTextField();
		tfActualizarPrecio.setBounds(610,530,100,20);
		panel.add(tfActualizarPrecio);
		
		btActualizar=new JButton("Actualizar");
		btActualizar.addActionListener(this);
		btActualizar.setBounds(500,560,100,20);
		panel.add(btActualizar);
		add (panel);
		setSize(900,650);
		setVisible(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		 //centramos la ventana en la mitad de la pantalla.
		setLocationRelativeTo(null);
		mostrarDatos();
	}
	
	public void mostrarDatos(){
		txtSalida.setText("");//vaciamos el texto de salida
		Connection c=ConexionBD.getConexion();
		Statement comando;
		try {
			comando = c.createStatement();
			ResultSet registro = comando.executeQuery("SELECT id,nombre_libro,editorial,autor,precio from libros where 1 ORDER BY id desc");
			txtSalida.setText("SALIDA DE DATOS \n");
			while (registro.next()) {
				int id;
				String nombres,editorial,autor,precio;
				id=registro.getInt("id");
				nombres=registro.getString("nombre_libro");
				editorial=registro.getString("editorial");
				autor=registro.getString("autor");
				precio=registro.getString("precio");
				
				txtSalida.append((id+" | "+nombres+ " | "+editorial+" | "+autor+ " | "+ precio+"\n" ));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ConexionBD.desconectar();
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btGuardar){
		Connection c=ConexionBD.getConexion();
		String sql = "INSERT INTO libros (nombre_libro,editorial,autor,precio) " + "VALUES (?, ?, ?, ?)";
		try {
		PreparedStatement st = c.prepareStatement(sql);
		st.setString(1, tfNombres.getText());
		st.setString(2, tfEditorial.getText());
		st.setString(3, tfAutor.getText());
		st.setString(4, tfPrecio.getText());
		st.executeUpdate();
		//vaciamos campos de entrada
		tfNombres.setText("");
		tfEditorial.setText("");
		tfAutor.setText("");
		tfPrecio.setText("");
		
		st.close();
		} catch (SQLException e1) {
		e1.printStackTrace();
		}
		mostrarDatos();
		ConexionBD.desconectar();
		}
		if (e.getSource()==btEliminar){
		Connection c=ConexionBD.getConexion();
		String sql = "DELETE FROM libros WHERE id = ?";
		try {
		PreparedStatement st = c.prepareStatement(sql);
		st.setString(1, tfIdEliminar.getText());
		st.executeUpdate();
		//vaciamos campos de entrada
		tfIdEliminar.setText("");
		st.close();
		} catch (SQLException e1) {
		e1.printStackTrace();
		}
		mostrarDatos();
		
		ConexionBD.desconectar();
		}
		if (e.getSource()==btActualizar){
		Connection c=ConexionBD.getConexion();
		String sql = "UPDATE libros SET nombre_libro = ?, editorial=?,  autor=?,  precio=? WHERE id = ?";
		try {
		PreparedStatement st = c.prepareStatement(sql);
		st.setString(1, tfActualizarNombres.getText());
		st.setString(2, tfActualizarEditorial.getText());
		st.setString(3, tfActualizarAutor.getText());
		st.setString(4, tfActualizarPrecio.getText());
		st.setString(5, tfIdActualizar.getText());
		st.executeUpdate();
		//vaciamos campos de entrada
		tfActualizarNombres.setText("");
		tfActualizarEditorial.setText("");
		tfActualizarAutor.setText("");
		tfActualizarPrecio.setText("");
		tfIdActualizar.setText("");
		st.close();
		} catch (SQLException e1) {
		e1.printStackTrace();
		
		}
	
		}
		mostrarDatos();
		ConexionBD.desconectar();
		}
		
		public static void main(String[] args) {
			new BaseDeDatos();
		}
}
