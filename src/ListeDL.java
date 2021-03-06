
public class ListeDL {

	static class ElementDL { // innere Klasse für die Elemente
		private Object inhalt; // Inhalt des Listenelements
		private ElementDL nach, vorg; // Verweis auf Nachfolger und Vorgänger

		public ElementDL(Object inhalt) {
			this.inhalt = inhalt;
		}
	}

	private ElementDL kopf; // Referenz auf Anfang der Liste
	private ElementDL ende; // Referenz auf das Ende der Liste

	public void endElementNachVorne() {
		ende.nach = kopf;
		kopf.vorg = ende;
		ende = ende.vorg;
		kopf = ende.nach;
		ende.nach = null;
		kopf.vorg = null;
		

	}

	public String toString() {
		String ausgabe = "";
		ElementDL temp = kopf;

		while(temp != null) {
			ausgabe = ausgabe + " " + temp.inhalt;
			temp = temp.nach;
		}

		return ausgabe;
	}

	public void einfuegen(Object eingabe) {
		ElementDL temp = new ElementDL(eingabe);
		if (kopf == null && ende == null) {
			kopf = temp;
			temp.vorg = null;
			ende = temp;
			ende.nach = null;
		} else {
			ende.nach = temp;
			temp.vorg = ende;
			ende = temp;
			temp.nach = null;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListeDL liste = new ListeDL();

		liste.einfuegen((int) 18);
		liste.einfuegen((int) 56);
		liste.einfuegen((int) 22);
		liste.einfuegen((int) 78);

		System.out.println(liste);
		
		liste.endElementNachVorne();
		
		System.out.println(liste);
	}

}
