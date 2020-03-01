//package com.tom.config;
//
//import org.hibernate.engine.transaction.jta.platform.internal.AbstractJtaPlatform;
//
//import javax.transaction.TransactionManager;
//import javax.transaction.UserTransaction;
//
///**
// * <p>
// *   Atomikos Jta Platform
// * </p>
// *
// * @author XiaoPengwei.com
// * @since 2019-04-13
// */
//public class AtomikosJtaPlatform extends AbstractJtaPlatform {
//
//	private static final long serialVersionUID = 1L;
//
//	static TransactionManager transactionManager;
//	static UserTransaction transaction;
//
//	@Override
//	protected TransactionManager locateTransactionManager() {
//		return transactionManager;
//	}
//
//	@Override
//	protected UserTransaction locateUserTransaction() {
//		return transaction;
//	}
//}
