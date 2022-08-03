package Vista;
import Modelo.vo.ComprasDeLiderVo;
import Modelo.vo.DeudasPorProyectoVo;
import Modelo.vo.ProyectoBancoVo;


public class ReportesView {
    private String repitaCaracter(Character caracter, Integer veces) {
        String respuesta = "";
        for (int i = 0; i < veces; i++) {
        respuesta += caracter;
        }
        return respuesta;
    }
        
    public void proyectosFinanciadosPorBanco(String banco) {
        System.out.println(repitaCaracter('=', 36) + " LISTADO DE PROYECTOS POR BANCO "
                            + repitaCaracter('=', 37));
        if (banco != null && !banco.isBlank()) {
            System.out.println(String.format("%3s %-25s %-20s %-15s %-7s %-30s", "ID", "CONSTRUCTORA", "CIUDAD", "CLASIFICACION", "ESTRATO", "LIDER"));
            System.out.println(repitaCaracter('-', 105));
            // TODO Imprimir en pantalla la información del proyecto
            try {
                ProyectoBancoVo.valores(banco);
                //stmt.close();
                //conn.close();
            } catch (Exception e) {
                //TODO: handle exception
                System.out.println(e);
            }
        }
    }
        
    public void totalAdeudadoPorProyectosSuperioresALimite(Double limiteInferior) {
        
        System.out.println(repitaCaracter('=', 1) + " TOTAL DEUDAS POR PROYECTO "
                            + repitaCaracter('=', 1));
        if (limiteInferior != null) {
            System.out.println(String.format("%3s %14s", "ID", "VALOR "));
            System.out.println(repitaCaracter('-', 29));
            // TODO Imprimir en pantalla la información del total adeudado
            DeudasPorProyectoVo.valores(limiteInferior);   
        }
    }
        
    public void lideresQueMasGastan() {
        System.out.println(repitaCaracter('=', 6) + " 10 LIDERES MAS COMPRADORES "
                            + repitaCaracter('=', 7));      
        System.out.println(String.format("%-25s %14s", "LIDER", "VALOR "));
        System.out.println(repitaCaracter('-', 41));
        // TODO Imprimir en pantalla la información de los líderes
        ComprasDeLiderVo.valores();
    }
}
