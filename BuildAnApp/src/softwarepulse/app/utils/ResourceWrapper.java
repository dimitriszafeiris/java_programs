/**
 * 
 */
package softwarepulse.app.utils;

/**
 * @author John McNeil
 * @copyright Software Pulse 2014
 *
 */
public class ResourceWrapper {
	
	public final String SEP = "/";
	public final char SEPC = '/';
	public final String filename;
	private final String absPath;
	final private String relToRootPath;
	
	public ResourceWrapper(String filename, String absPath) {
		super();
		this.filename = filename.trim();
		//this.absPath = absPath;
		
		String path = absPath.trim().replace('/', SEPC).replace('\\', SEPC);
		if(path.length() == 0 || (path.charAt(0) != SEPC )) {
			path = SEPC + path;
		}
		if(path.length() > 1 && path.charAt(path.length() - 1) == SEPC) {
			path.substring(0, path.length()-2);
		}
		
		this.absPath = path;
		this.relToRootPath = this.absPath.substring(1);
	}

	/**
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}
	
	public String getNameRelativeToRoot() {
		if(absPath.equals(SEP)) {
			return this.filename;
		}
		return relToRootPath.concat(SEP).concat(filename);
	}
	
	
	public String getAbsoluteName() {
		if(absPath.equals(SEP)) {
			return absPath.concat(filename);
		}
		return absPath.concat(SEP).concat(filename);
	}
	
}