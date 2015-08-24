package loon.core;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

import loon.Files.FileType;


public abstract class FileHandleStream extends FileHandle {

	public FileHandleStream(String path) {
		super(new File(path), FileType.Absolute);
	}

	public boolean isDirectory() {
		return false;
	}

	public long length() {
		return 0;
	}

	public boolean exists() {
		return true;
	}

	public FileHandle child(String name) {
		throw new UnsupportedOperationException();
	}

	public FileHandle sibling(String name) {
		throw new UnsupportedOperationException();
	}

	public FileHandle parent() {
		throw new UnsupportedOperationException();
	}

	public InputStream read() {
		throw new UnsupportedOperationException();
	}

	public OutputStream write(boolean overwrite) {
		throw new UnsupportedOperationException();
	}

	public FileHandle[] list() {
		throw new UnsupportedOperationException();
	}

	public void mkdirs() {
		throw new UnsupportedOperationException();
	}

	public boolean delete() {
		throw new UnsupportedOperationException();
	}

	public boolean deleteDirectory() {
		throw new UnsupportedOperationException();
	}

	public void copyTo(FileHandle dest) {
		throw new UnsupportedOperationException();
	}

	public void moveTo(FileHandle dest) {
		throw new UnsupportedOperationException();
	}
}
