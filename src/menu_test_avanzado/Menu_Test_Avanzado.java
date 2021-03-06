 
package menu_Test_Avanzado;     
 
 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 
import javax.swing.text.*; 

 
public class Menu_Test_Avanzado {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MenuProcesador_III mimarco = new MenuProcesador_III(); 
        
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);          
        
        mimarco.setVisible(true); 
    }    
}

 class MenuProcesador_III extends JFrame{
    
    public MenuProcesador_III(){
        
       setTitle("Menú Test Avanzado");
        
       setBounds(450, 150, 550, 500);  
       
       LaminaProcesador milamina = new LaminaProcesador();
       
       add(milamina);
       
       setVisible(true);
       
    }    
} 

class LaminaProcesador extends JPanel{
    
    public LaminaProcesador(){ 
     
        setLayout(new BorderLayout());        
        JPanel lamina_menu = new JPanel();

        //---------------------------------------------------------
        /*Aqui creo la barra*/
        JMenuBar mi_barra = new JMenuBar(); 

        /*Aqui creo los botones que van en la barra*/
        edicion = new JMenu("Edición");
        fuente = new JMenu("Fuente");        
        estilo = new JMenu("Estilo");        
        tamagno = new JMenu("Tamaño");        

        //---------------------------------------------------------
        configura_menu("Arial", "fuente", "Arial",1,1, "");
        configura_menu("Calibri", "fuente", "Calibri",1,1, "");
        configura_menu("Verdana", "fuente", "Verdana",1,1, "");
        //---------------------------------------------------------
        configura_menu("Negrita", "estilo","", Font.BOLD,1, "src/menu_Test_Avanzado/graficos/negrita.gif");
        configura_menu("Cursiva", "estilo","", Font.ITALIC,1, "src/menu_Test_Avanzado/graficos/cursiva.gif"); 

        //---------------------------------------------------------

        /* Sub-Menu de Edición */        
        JMenuItem cortar = new JMenuItem("Cortar", new ImageIcon("src/menu_Test_Avanzado/graficos/cortar.gif"));

        JMenuItem copiar = new JMenuItem("Copiar", new ImageIcon("src/menu_Test_Avanzado/graficos/copiar.gif"));

        JMenuItem pegar = new JMenuItem("Pegar", new ImageIcon("src/menu_Test_Avanzado/graficos/pegar.gif"));
        
        cortar.addActionListener(new StyledEditorKit.CutAction());
        copiar.addActionListener(new StyledEditorKit.CopyAction());
        pegar.addActionListener(new StyledEditorKit.PasteAction());

        //---------------------------------------------------------        
         /* Edicion */  
        edicion.add(cortar);        
        edicion.add(copiar);        
        edicion.add(pegar); 

        //---------------------------------------------------------

        ButtonGroup tamagno_letra = new ButtonGroup();

        JRadioButtonMenuItem doce = new JRadioButtonMenuItem("12");

        JRadioButtonMenuItem dieciseis = new JRadioButtonMenuItem("16");

        JRadioButtonMenuItem veinte = new JRadioButtonMenuItem("20");

        JRadioButtonMenuItem veinticuatro = new JRadioButtonMenuItem("24");

        veinticuatro.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));

        tamagno_letra.add(doce);
        tamagno_letra.add(dieciseis);
        tamagno_letra.add(veinte);
        tamagno_letra.add(veinticuatro);
        
        doce.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamaño", 12));

        dieciseis.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamaño", 16));

        veinte.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamaño", 20));

        veinticuatro.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamaño", 24));

        tamagno.add(doce);
        tamagno.add(dieciseis);
        tamagno.add(veinte);
        tamagno.add(veinticuatro); 
        //--------------------------------------------------------  
       
        /*Aqui agrego los botones a la barra*/
        mi_barra.add(edicion);
        mi_barra.add(fuente);        
        mi_barra.add(estilo);        
        mi_barra.add(tamagno);
        //---------------------------------------------------------
        /*Aqui agrego la barra a la LAMINA*/
        lamina_menu.add(mi_barra);
        /*Aqui muestro todo y coloco en el norte de la lamina*/
        add(lamina_menu, BorderLayout.NORTH);
        
        miarea = new JTextPane(); 
        
        laminaConBarras = new JScrollPane(miarea);
        
        add(laminaConBarras, BorderLayout.CENTER);
        
        /* --------   Menu PopUp  --------------------  */
        
        JPopupMenu emergente = new JPopupMenu(); 
        
        JMenuItem negritaEmergente = new JMenuItem("Negrita");
                        
        JMenuItem cursivaEmergente = new JMenuItem("Cursiva"); 
        
        JMenuItem cortarEmergente = new JMenuItem("Cortar"); 
        JMenuItem copiarEmergente = new JMenuItem("Copiar"); 
        JMenuItem pegarEmergente = new JMenuItem("Pegar");      
             
        cortarEmergente.addActionListener(new StyledEditorKit.CutAction());
        copiarEmergente.addActionListener(new StyledEditorKit.CopyAction());
        pegarEmergente.addActionListener(new StyledEditorKit.PasteAction());
        
        negritaEmergente.addActionListener(new StyledEditorKit.BoldAction());        
        cursivaEmergente.addActionListener(new StyledEditorKit.ItalicAction());
        
        emergente.add(cortarEmergente);
        emergente.add(copiarEmergente);
        emergente.add(pegarEmergente);
        emergente.addSeparator();
        emergente.add(negritaEmergente);        
        emergente.add(cursivaEmergente);
        
        miarea.setComponentPopupMenu(emergente);
        
        //---------------------------------------------------------
    
        barra = new JToolBar();
        
        configura_barra("src/menu_Test_Avanzado/graficos/negrita.gif").addActionListener(new StyledEditorKit.BoldAction());  
        configura_barra("src/menu_Test_Avanzado/graficos/cursiva.gif").addActionListener(new StyledEditorKit.ItalicAction());
        configura_barra("src/menu_Test_Avanzado/graficos/subrayado.gif").addActionListener(new StyledEditorKit.UnderlineAction());
        barra.addSeparator();
        configura_barra("src/menu_Test_Avanzado/graficos/azul.gif").addActionListener(new StyledEditorKit.ForegroundAction("Pone_azul", Color.BLUE));
        configura_barra("src/menu_Test_Avanzado/graficos/amarilla.gif").addActionListener(new StyledEditorKit.ForegroundAction("Pone_amarilla", Color.YELLOW));
        configura_barra("src/menu_Test_Avanzado/graficos/roja.gif").addActionListener(new StyledEditorKit.ForegroundAction("Pone_roja", Color.RED));
        configura_barra("src/menu_Test_Avanzado/graficos/negro.gif").addActionListener(new StyledEditorKit.ForegroundAction("Pone_roja", Color.BLACK));
        barra.addSeparator();
        configura_barra("src/menu_Test_Avanzado/graficos/a_izquierda.gif").addActionListener(new StyledEditorKit.AlignmentAction("Texto_Izquierda", 0));
        configura_barra("src/menu_Test_Avanzado/graficos/a_centro.gif").addActionListener(new StyledEditorKit.AlignmentAction("Texto_Centrado", 1));
        configura_barra("src/menu_Test_Avanzado/graficos/a_derecha.gif").addActionListener(new StyledEditorKit.AlignmentAction("Texto_Derecha", 2));
        configura_barra("src/menu_Test_Avanzado/graficos/a_justificado.gif").addActionListener(new StyledEditorKit.AlignmentAction("Texto_Justificado", 3));
          
        
        //Coloca los iconos de forma Vertical en la barra!!!
        barra.setOrientation(1);
        
        //ahora coloco la barra de herramientas en el panel!
        add(barra, BorderLayout.WEST); 
    }
    
    public JButton configura_barra(String ruta){
        
        JButton boton = new JButton(new ImageIcon(ruta));
        
        barra.add(boton);        
        
        return boton;
        
    }
    
    public void configura_menu (String rotulo, String menu, String tipo_letra, int estilos, int tam, String ruta_icono){
        
        JMenuItem elem_menu = new JMenuItem(rotulo, new ImageIcon(ruta_icono));
        //Construyo los elementos del menu
        if (menu=="fuente"){
            
            fuente.add(elem_menu);
            
            if (tipo_letra == "Arial"){
                
                elem_menu.addActionListener(new StyledEditorKit.FontFamilyAction("cambia_letra", "Arial"));
                
            }else if (tipo_letra == "Calibri"){
                
                 elem_menu.addActionListener(new StyledEditorKit.FontFamilyAction("cambia_letra", "Calibri"));
                
            }else if (tipo_letra == "Verdana"){
            
                 elem_menu.addActionListener(new StyledEditorKit.FontFamilyAction("cambia_letra", "Verdana"));
            
            } 
         }else if (menu=="estilo"){
            
            estilo.add(elem_menu);
            
            if(estilos == Font.BOLD){
                
                elem_menu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
                
                elem_menu.addActionListener(new StyledEditorKit.BoldAction());
            }else if (estilos == Font.ITALIC){
                
                elem_menu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, InputEvent.CTRL_DOWN_MASK));
                
                elem_menu.addActionListener(new StyledEditorKit.ItalicAction());
            } 
              
        }else if(menu=="tamaño"){
            
            tamagno.add(elem_menu);
            
            elem_menu.addActionListener(new StyledEditorKit.FontSizeAction("cambia_tamaño", tam));
        }        
 }
    private JScrollPane laminaConBarras;
    JTextPane miarea; 
    JMenu edicion, fuente, estilo, tamagno, linea;
    Font letras;
    JButton negritaBarra, cursivaBarra, subrayaBarra, azulBarra, amarilloBarra, rojoBarra;
    JButton align_izquierda, align_centro, align_derecha, align_justificado;
    JToolBar barra;
}
 
     