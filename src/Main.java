import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {
    public static void main(String[] args) {
        JFrame ventana = new JFrame(); //creamos objeto que representa la ventana
        ventana.setSize(1600, 900); //Tamaño de la ventana
        ventana.setTitle("Probando la librería Swing en Java"); //Título de la ventana
        ventana.setResizable(false); // Evitamos la redimensión de la ventana
        ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//el programa se acaba al cerrar la ventana

        JMenuBar barraDeMenu = new JMenuBar(); //Creamos la barra de menú

        //Creamos el primer botón de menú (Archivo) y lo agregamos a la barra de menú
        JMenu menuArchivo = new JMenu("Archivo");
        barraDeMenu.add(menuArchivo);

        //Creamos el segundo botón de menú (Acciones) y lo agregamos a la barra de menú
        JMenu menuAcciones = new JMenu("Acciones");
        barraDeMenu.add(menuAcciones);

        //Creamos el tercer botón de menú (Ayuda) y lo agregamos a la barra de menú
        JMenu menuAyuda = new JMenu("Ayuda");
        barraDeMenu.add(menuAyuda);

        //Creamos el elemento "Versión" en el menú Ayuda
        JMenuItem menuItemVersion = new JMenuItem("Versión");
        menuAyuda.add(menuItemVersion);
        //Añadimos un evento al elemento "Versión" del menú Ayuda
        menuItemVersion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(ventana, "Versión del programa: 1.0", "Versión", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        //Creamos el elemento "Acerca de" en el menú Ayuda
        JMenuItem menuItemAcercaDe = new JMenuItem("Acerca de");
        menuAyuda.add(menuItemAcercaDe);

        //Añadimos un evento al elemento "Acerca de" del menú Ayuda
        menuItemAcercaDe.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(ventana, "Este programa es una aplicación de prueba para demostrar el uso de la librería Swing en Java.", "Acerca de", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        //Agregamos la barra de menú a la ventana
        ventana.setJMenuBar(barraDeMenu);

        //Creamos el botón Nueva Liga
        JButton boton = new JButton("Nueva Liga");
        boton.setPreferredSize(new Dimension(150, 50)); // Establecemos tamaño personalizado

        //Asignamos un evento al botón de "Nueva Liga"
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Creando una nueva liga");
            }
        });

        //Creamos el botón Jugar Liga
        JButton botonJugarLiga = new JButton("Jugar Liga");
        botonJugarLiga.setPreferredSize(new Dimension(150, 50)); // Establecemos tamaño personalizado

        botonJugarLiga.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("Al hacer click en este botón se simulará una liga al completo");
            }
        });


        //Creamos el botón Siguiente Jornada
        JButton botonSiguienteJornada = new JButton("Siguiente Jornada");
        botonSiguienteJornada.setEnabled(true); // deshabilitamos el botón por defecto// en la semana 21 lo activamos para el evento
        botonSiguienteJornada.setPreferredSize(new Dimension(150, 50)); // Establecemos tamaño personalizado

        botonSiguienteJornada.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Se va a proceder a simular una jornada");
            }
        });



        //Creamos el botón Simulación Completa
        JButton botonSimulacionCompleta = new JButton("Simulación Completa");
        botonSimulacionCompleta.setEnabled(false); // deshabilitamos el botón por defecto
        botonSimulacionCompleta.setPreferredSize(new Dimension(200, 50)); // Establecemos tamaño personalizado

        //Creamos el botón Salir
        JButton botonSalir = new JButton("Salir");
        botonSalir.setPreferredSize(new Dimension(150, 50)); // Establecemos tamaño personalizado

        //Agregamos un ActionListener al botón Salir para terminar el programa
        botonSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        //Creamos un JPanel para agrupar los botones
        JPanel panelBotones = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0, 10, 20, 500);
        panelBotones.add(boton, c);
        //Agregamos un espacio rígido de 20 píxeles entre los botones
        c.gridx = 0;
        c.gridy = 1;
        panelBotones.add(Box.createRigidArea(new Dimension(0, 20)), c); // Añadimos un espacio rígido de 20 píxeles
        c.gridx = 0;
        c.gridy = 2;
        panelBotones.add(botonJugarLiga, c);
        c.gridx = 0;
        c.gridy = 3;
        panelBotones.add(Box.createRigidArea(new Dimension(0, 20)), c); // Añadimos un espacio rígido de 20 píxeles
        c.gridx = 0;
        c.gridy = 4;
        panelBotones.add(botonSiguienteJornada, c);
        c.gridx = 0;
        c.gridy = 5;
        panelBotones.add(Box.createRigidArea(new Dimension(0, 20)), c); // Añadimos un espacio rígido de 20 píxeles
        c.gridx = 0;
        c.gridy = 6;
        panelBotones.add(botonSimulacionCompleta, c);
        c.gridx = 0;
        c.gridy = 7;
        panelBotones.add(Box.createRigidArea(new Dimension(0, 20)), c); // Añadimos un espacio rígido de 20 píxeles
        c.gridx = 0;
        c.gridy = 8;
        panelBotones.add(botonSalir, c);
        c.gridx = 0;
        c.gridy = 9;
        c.weighty = 1;
        panelBotones.add(Box.createVerticalGlue(), c); // Añadimos otro espacio en blanco para centrar los botones verticalmente
        //Creamos un JPanel para agrupar la tabla
        JPanel panelTabla = new JPanel();
        panelTabla.setLayout(new BorderLayout());
        panelTabla.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Añadimos un borde vacío
        panelTabla.setPreferredSize(new Dimension(1000, 800));

        //Creamos la tabla
        DefaultTableModel mitabla = new DefaultTableModel();

        //Creamos columnas
        mitabla.addColumn("Nombre del equipo");
        mitabla.addColumn("Partidos jugados");
        mitabla.addColumn("Victorias");
        mitabla.addColumn("Derrotas");
        mitabla.addColumn("Empates");
        JTable tabla = new JTable(mitabla);

        //añadimos la tabla al panel
        JScrollPane scroll = new JScrollPane(tabla);
        panelTabla.add(scroll, BorderLayout.CENTER);

        //Creamos filas
        mitabla.addRow(new Object[]{"Real Madrid", 34, 22, 6, 6});
        mitabla.addRow(new Object[]{"Barcelona", 34, 22, 5, 7});
        mitabla.addRow(new Object[]{"Atletico de Madrid", 34, 20, 8, 6});
        mitabla.addRow(new Object[]{"Sevilla", 34, 20, 4, 10});
        mitabla.addRow(new Object[]{"Real Sociedad", 34, 14, 11, 9});
        mitabla.addRow(new Object[]{"Villarreal", 34, 13, 13, 8});
        mitabla.addRow(new Object[]{"Real Betis", 34, 14, 9, 11});
        mitabla.addRow(new Object[]{"Athletic Club", 34, 11, 12, 11});
        mitabla.addRow(new Object[]{"Celta de Vigo", 34, 10, 12, 12});
        mitabla.addRow(new Object[]{"Granada", 34, 10, 9, 15});
        mitabla.addRow(new Object[]{"Levante", 34, 9, 12, 13});
        mitabla.addRow(new Object[]{"Valencia", 34, 8, 12, 14});
        mitabla.addRow(new Object[]{"Osasuna", 34, 8, 11, 15});
        mitabla.addRow(new Object[]{"Cadiz", 34, 7, 11, 16});
        mitabla.addRow(new Object[]{"Alaves", 34, 6, 10, 18});
        mitabla.addRow(new Object[]{"Elche", 34, 5, 12, 17});
        mitabla.addRow(new Object[]{"Getafe", 34, 6, 9, 19});
        mitabla.addRow(new Object[]{"Huesca", 34, 5, 12, 17});
        mitabla.addRow(new Object[]{"Real Valladolid", 34, 5, 12, 17});
        mitabla.addRow(new Object[]{"Eibar", 34, 4, 13, 17});

        //Establecemos la altura de las filas
        tabla.setRowHeight(40);

        //Creamos un panel principal para agregar los paneles de botones y la tabla
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(1, 2)); // 1 fila, 2 columnas
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Añadimos un borde vacío
        panelPrincipal.add(panelBotones);
        panelPrincipal.add(panelTabla);

        //Agregamos el panel principal a la ventana
        ventana.add(panelPrincipal);
        ventana.setVisible(true);// así la ventana es visible
    }
}