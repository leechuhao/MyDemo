package lichuhao3115005534.util;

/**
 * �ַ���������
 * @author H_Pioneer
 *
 */
public class StringUtil {
    /**
     * �ж��Ƿ�Ϊ��
     * @param str
     * @return
     */

    public static boolean isEmpty(String str){
        if(str==null||"".equals(str.trim())){
            return true;
        }else{
        	return false;
        }
    }

    /**
     * �жϲ�Ϊ��
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str){
        if(str!=null&&!"".equals(str.trim())){
            return true;
        }else{
        	return false;
        }
    }
}