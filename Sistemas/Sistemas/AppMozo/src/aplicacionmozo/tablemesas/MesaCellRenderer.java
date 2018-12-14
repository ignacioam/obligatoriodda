package aplicacionmozo.tablemesas;

import entidades.Mesa;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Juan, Ignacio
 */
public class MesaCellRenderer extends JLabel implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (value != null) {
            MatteBorder border;
            this.setHorizontalAlignment(JLabel.CENTER);
            if (isSelected) {
                border = new MatteBorder(1, 1, 1, 1, Color.blue);
                this.setFont(new Font("Arial", Font.BOLD, 25));
            } else {
                border = new MatteBorder(1, 1, 1, 1, Color.black);
                this.setFont(new Font("Arial", Font.PLAIN, 15));
            }
            this.setBorder(border);
            Mesa m = (Mesa) value;
            this.setText(String.valueOf(m.getNumero()));
            this.setOpaque(true);
            if (m.isAbierta()) {
                this.setIcon(new ImageIcon(getClass().getResource("/aplicacionmozo/views/resources/imgs/tableIconOpen.png")));
            } else {
                this.setIcon(new ImageIcon(getClass().getResource("/aplicacionmozo/views/resources/imgs/tableIconClosed.png")));
            }
            return this;
        }
        return null;
    }

}
