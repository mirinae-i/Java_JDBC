package com.mirinae.learnjava;

import com.mirinae.db.Connect;

final class Main {

	public static final void main(String[] args) {
		
		Connect connect = new Connect();
		connect.checkConn();
		connect.select();
		connect.insert("Lumi", "lumina22", "1q2w3e4r!");
		connect.select();
	}
}
