package Entities;

import android.content.Context;

/**
 * Created by Xavier on 31.05.16.
 *
 *  An XMLoadable object of class Thing can be loaded from an XML file which has the following structure:
 *
 *  <Things>
 *      <Thing>
 *          <id>...</id>
 *          ...
 *      </Thing>
 *      <Thing>
 *          <id>...</id>
 *          ...
 *      </Thing>
 *      <Thing>
 *          <id>...</id>
 *          ...
 *      </Thing>
 *  </Things>
 *
 *  The file is retrieved over the network using its URL:  server/Things.xml
 */
public interface XMLoadable
{
    public boolean load_id (Integer id);
    public boolean load_index (int index);
    public int numberOfCandidates();
    public void refresh();
}
