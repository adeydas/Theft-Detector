package ws.abhis.apps.TheftDetector;

public class ConfigType {
	private String smtpHost;
	private String tlsEnable;
	private String smtpFrom;
	private String smtpTo;
	public String getSmtpTo() {
		return smtpTo;
	}

	public void setSmtpTo(String smtpTo) {
		this.smtpTo = smtpTo;
	}

	public String getSmtpFrom() {
		return smtpFrom;
	}

	public void setSmtpFrom(String smtpFrom) {
		this.smtpFrom = smtpFrom;
	}

	private String smtpUser;
	private String smtpPass;
	private String smtpPort;
	private String smtpAuth;
	
	private String remoteUri;

	public String getSmtpHost() {
		return smtpHost;
	}

	public void setSmtpHost(String smtpHost) {
		this.smtpHost = smtpHost;
	}

	public String isTlsEnable() {
		return tlsEnable;
	}

	public void setTlsEnable(String tlsEnable) {
		this.tlsEnable = tlsEnable;
	}

	public String getSmtpUser() {
		return smtpUser;
	}

	public void setSmtpUser(String smtpUser) {
		this.smtpUser = smtpUser;
	}

	public String getSmtpPass() {
		return smtpPass;
	}

	public void setSmtpPass(String smtpPass) {
		this.smtpPass = smtpPass;
	}

	public String getSmtpPort() {
		return smtpPort;
	}

	public void setSmtpPort(String smtpPort) {
		this.smtpPort = smtpPort;
	}

	public String getSmtpAuth() {
		return smtpAuth;
	}

	public void setSmtpAuth(String smtpAuth) {
		this.smtpAuth = smtpAuth;
	}

	public String getRemoteUri() {
		return remoteUri;
	}

	public void setRemoteUri(String remoteUri) {
		this.remoteUri = remoteUri;
	}
	
	
	
	
}
