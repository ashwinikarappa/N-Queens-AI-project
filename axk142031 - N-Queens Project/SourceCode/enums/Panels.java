package ai.star.enums;

public enum Panels {
	SOLVE("Solutions"), COMPARE("Compare Solutions");

	private String panelType;

	public String getPanelType() {
		return panelType;
	}

	private Panels(String panelType) {
		this.panelType = panelType;
	}

}
