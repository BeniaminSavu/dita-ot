/*
 * This file is part of the DITA Open Toolkit project hosted on
 * Sourceforge.net. See the accompanying license.txt file for 
 * applicable licenses.
 */

/*
 * (c) Copyright IBM Corp. 2005, 2006 All Rights Reserved.
 */
package org.dita.dost.platform;

import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

import org.dita.dost.util.Constants;

/**
 * ImportAction implements IAction and import the resource 
 * provided by plug-ins into the xsl files and ant scripts.
 * @author Zhang, Yuan Peng
 */
public abstract class ImportAction implements IAction {
	protected Set<String> valueSet = null;
	protected Hashtable<String,String> paramTable = null;
	
	/**
	 * Default Constructor.
	 */
	public ImportAction() {
		valueSet = new LinkedHashSet<String>(Constants.INT_16);
		paramTable = new Hashtable<String,String>();
	}
	
	/**
	 * get result.
	 * @return result
	 * @see org.dita.dost.platform.IAction#getResult()
	 */
	public abstract String getResult();

	/**
	 * set input.
	 * @param input input
	 * @see org.dita.dost.platform.IAction#setInput(java.lang.String)
	 */
	public void setInput(String input) {
		StringTokenizer inputTokenizer = new StringTokenizer(input,",");
		while(inputTokenizer.hasMoreElements()){
			valueSet.add((String) inputTokenizer.nextElement());
		}
	}

	/**
	 * Set the input parameters.
	 * @param param param
	 * @see org.dita.dost.platform.IAction#setParam(java.lang.String)
	 */
	public void setParam(String param) {
		StringTokenizer paramTokenizer = new StringTokenizer(param,";");
		String paramExpression = null;
		int index;
		while(paramTokenizer.hasMoreElements()){
			paramExpression = (String) paramTokenizer.nextElement();
			index = paramExpression.indexOf("=");
			if(index > 0){
				paramTable.put(paramExpression.substring(0,index),
						paramExpression.substring(index+1));
			}
		}	
	}
	/**
	 * Set the feature table.
	 * @param h hastable
	 */
	public void setFeatures(Hashtable<String,String> h) {
		
	}

}
