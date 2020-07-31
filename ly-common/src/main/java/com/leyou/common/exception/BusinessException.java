package com.leyou.common.exception;

import lombok.Data;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Data
@Component
public class BusinessException extends Exception {

    private static final long serialVersionUID = -4648879327187605014L;
    private static Map<String, String> CODES_MAP = null;
    private static final String DEFAULT_ERROR_CODE_MESSAGE = "系统内部错误";
    private static final String UNDEFINED_ERROR = "未定义错误";
    private static final String EXCEPTION_MESSAGE_PROPERTIES = "business-exceptions.properties";
    private final static Logger logger = LoggerFactory.getLogger(BusinessException.class);

    /**
     * 本异常错误代码
     */
    private String errorCode = "500";

    private String describe = "";

    static {
        BusinessException.init();
    }

    private synchronized static void init() {
        if (null == BusinessException.CODES_MAP) {
            BusinessException.CODES_MAP = new HashMap<>();
            BusinessException.CODES_MAP.put("0", BusinessException.DEFAULT_ERROR_CODE_MESSAGE);
            PropertiesConfiguration config = null;
            try {
                config = new PropertiesConfiguration();
                config.setEncoding("utf8");
                config.load(BusinessException.EXCEPTION_MESSAGE_PROPERTIES);
            } catch (ConfigurationException e) {
                BusinessException.logger.error("[business exception] get pro file error:", e);
            }
            BusinessException.logger.info("[business exception] init start...");
            if (config != null) {
                Iterator<String> keyIterator = config.getKeys();
                while (keyIterator.hasNext()) {
                    String key = keyIterator.next();
                    if (NumberUtils.isNumber(key)) {
                        BusinessException.CODES_MAP.put(key, config.getString(key));
                        BusinessException.logger.info("[business exception] add exception:code=" + key + ",message=" + config.getString(key));
                    } else {
                        BusinessException.logger.info("[business exception] add exception:code=" + key + ",message=" + config.getString(key));
                    }
                }
            }
            BusinessException.logger.info("[business exception] init exception map suc.");
        }
    }

    public BusinessException(String errorCode) {
        super();
        this.errorCode = errorCode;
    }
    public BusinessException(String errorCode, String describe) {
        super();
        this.errorCode = errorCode;
        this.describe = describe;
    }

    @Override
    public String getMessage() {
        return getLocalizedMessage();
    }

    @Override
    public String getLocalizedMessage() {
        String localMessage = BusinessException.CODES_MAP.get(this.errorCode);
        if (StringUtils.isEmpty(BusinessException.CODES_MAP.get(this.errorCode))) {
            localMessage = UNDEFINED_ERROR;
        }
        return localMessage;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
