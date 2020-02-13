package com.yz.sophia.bsf.file;


import com.yz.sophia.bsf.core.base.BsfException;

/**
 * @author Huang Zhaoping
 */
public class FileException extends BsfException {

	private static final long serialVersionUID = 1L;

	public FileException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileException(String message) {
        super(message);
    }
}
