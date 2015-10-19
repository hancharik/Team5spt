/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentprogramtester.controler;

import java.io.*;


public class FileFilter implements FilenameFilter
{  
  public boolean accept(File dir, String name)
  {
	if(name.endsWith(".java"))
	{
	  return true;
	}
	else
	{
	  return false;
	}
  }
}
