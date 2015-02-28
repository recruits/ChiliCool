package com.zzc.study.agile.chapter1;

public class RosterReport {
	public final static String NEWLINE = System.getProperty("line.separator");
	public final static String ROSTER_REPORT_HEADER = "Student" + NEWLINE
			+ "-----" + NEWLINE;
	public final static String ROSTER_REPORT_FOOTER = NEWLINE + "# students = ";

	private CourseSession session;

	public RosterReport(CourseSession session) {
		this.session = session;
	}

	public String getReport() {
		StringBuilder buffer = new StringBuilder();
		
		writeHeader(buffer);
		writeBody(buffer);
		writeFooter(buffer);
		
		return buffer.toString();
	}

	private void writeHeader(StringBuilder buffer) {
		buffer.append(ROSTER_REPORT_HEADER);
	}
	private void writeBody(StringBuilder buffer) {
		for (Student student : session.getAllStudents()) {
			buffer.append(student.getName()).append(NEWLINE);
		}
	}
	private void writeFooter(StringBuilder buffer) {
		buffer.append(ROSTER_REPORT_FOOTER)
				.append(session.getNumberOfStudents()).append(NEWLINE);
	}
}
