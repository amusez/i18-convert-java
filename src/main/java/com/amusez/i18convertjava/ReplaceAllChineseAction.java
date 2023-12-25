//package com.amusez.i18convertjava;
//
//import com.intellij.lang.java.JavaLanguage;
//import com.intellij.openapi.actionSystem.AnAction;
//import com.intellij.openapi.actionSystem.AnActionEvent;
//import com.intellij.openapi.actionSystem.CommonDataKeys;
//import com.intellij.openapi.command.WriteCommandAction;
//import com.intellij.openapi.diagnostic.Logger;
//import com.intellij.openapi.editor.Document;
//import com.intellij.openapi.editor.Editor;
//import com.intellij.openapi.project.Project;
//import com.intellij.openapi.util.TextRange;
//import com.intellij.psi.*;
//import com.intellij.psi.search.GlobalSearchScope;
//import com.intellij.psi.util.PsiTreeUtil;
//import org.apache.commons.collections.CollectionUtils;
//import org.apache.commons.lang.math.RandomUtils;
//import org.apache.commons.lang3.StringUtils;
//import org.jetbrains.annotations.NotNull;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//public class ReplaceAllChineseAction extends AnAction {
//
//    private final Logger log = Logger.getInstance(ReplaceAllChineseAction.class);
//
//
//    @Override
//    public void actionPerformed(AnActionEvent event) {
//        log.info("actionPerformed start...");
//        // 获取当前project
//        Project project = event.getRequiredData(CommonDataKeys.PROJECT);
//        log.info("projectService.getName() " + project.getName());
//        // 获取当前编辑器
//        Editor editor = event.getRequiredData(CommonDataKeys.EDITOR);
//        // 获取当前打开的文件
//        Document document = editor.getDocument();
//
//        PsiJavaParserFacade parserFacade = JavaPsiFacade.getInstance(project).getParserFacade();
//
//        PsiFile psiFile = PsiDocumentManager.getInstance(project).getPsiFile(document);
//        PsiJavaFile currentJavaFile = (PsiJavaFile) psiFile;
//
//        // 获取当前文件中所有的java类
//        PsiClass[] classArray = currentJavaFile.getClasses();
//
//        String classz = "com.example.test.enums.I18BaseEnum.I18ConstantEnum";
//        PsiClass i18EnumClass = JavaPsiFacade.getInstance(project).findClass(classz, GlobalSearchScope.projectScope(project));
//        if (i18EnumClass == null) {
//            log.error("未获取到i18枚举类,不再继续运行:" + classz);
//            return;
//        }
//
//        for (PsiClass currentClass : classArray) {
//            if (currentClass.isInterface()) {
//                for (PsiClass innerClass : currentClass.getInnerClasses()) {
//                    if (innerClass.isEnum()) {
//                        log.info("当前类为interface,存在内部枚举:" + currentClass.getName() + "," + innerClass.getName());
//                    }
//                }
//            } else if (currentClass.isEnum()) {
//                log.info("当前类为enum:" + currentClass.getName());
//            } else {
//                // 默认普通类 获取所有的child元素
//                @NotNull PsiElement[] childrenArray = currentClass.getChildren();
//                List<PsiElement> allChildList = new ArrayList<>();
//                for (PsiElement child : childrenArray) {
//                    if (child.getLanguage().equals(JavaLanguage.INSTANCE)) {
//                        // java语言
//                        replaceChinese(child, project, document);
//                    }
//                }
//            }
//        }
////        WriteCommandAction.writeCommandAction(project).run(() -> {
////            JavaCodeStyleManager.getInstance(project).shortenClassReferences(currentJavaFile, JavaCodeStyleManager.INCOMPLETE_CODE);
////        });
//
//
//        log.info("actionPerformed end...");
//
//    }
//
//    private void replaceChinese(PsiElement psiElement, Project project, Document document) {
//        List<PsiJavaToken> childrenOfTypeAsList = PsiTreeUtil.getChildrenOfTypeAsList(psiElement, PsiJavaToken.class);
//        // 开始解析java class
//        for (PsiJavaToken psiJavaToken : childrenOfTypeAsList) {
//
//            // 是String
//            if (psiJavaToken.getTokenType().equals(JavaTokenType.STRING_LITERAL)) {
//                if (isContainsChinese(psiJavaToken.getText())) {
//                    // 含有中文
//                    // 获取注解
//                    PsiAnnotation psiAnnotation = PsiTreeUtil.getParentOfType(psiElement, PsiAnnotation.class);
//                    if (psiAnnotation != null) {
//                        // 判断是否为swagger的注解
//                        if (!psiAnnotation.getQualifiedName().startsWith("io.swagger.annotations")) {
//                            // 非swagger注解,需要处理中文信息
//                            log.info("非swagger注解,需要处理:" + psiElement.getText());
//                            // i18枚举模板
//                            String enumTemplate = "%s(\"%s\",\"%s\")";
//                            String str = "CODE_" + RandomUtils.nextInt(1000);
//                            String codeTemplate = "PROJECT_MODULE_" + str;
////                                        String i18Desc = "EN_" + element.getText();
//                            String i18Desc = psiElement.getText();
//                            log.info("i18Desc:" + i18Desc);
//                            // 生成枚举
//                            WriteCommandAction.writeCommandAction(project).run(() -> {
////                                            PsiEnumConstant constant = parserFacade.createEnumConstantFromText(String.format(enumTemplate, codeTemplate, str, i18Desc
////                                            ), i18EnumClass);
////                                            i18EnumClass.add(constant);
////                                            PsiElement whiteSpaceFormText = PsiParserFacade.getInstance(project).createWhiteSpaceFromText("\"" + str + "\"");
//                                            PsiElement whiteSpaceFormText = JavaPsiFacade.getInstance(project).getParserFacade()
//                                                    .createExpressionFromText("\"" + str + "\"",psiElement);
////                                TextRange textRangeInParent = psiElement.getTextRange();
////                                document.replaceString(textRangeInParent.getStartOffset(), textRangeInParent.getEndOffset(), codeTemplate);
////                                            currentClass.add(whiteSpaceFormText);
//                                psiJavaToken.getParent().replace(whiteSpaceFormText);
//                            });
//                        }
//                    }
//                }
//            }
//        }
//        for (PsiElement element : psiElement.getChildren()) {
//            replaceChinese(element, project, document);
//        }
//    }
//
//    private void getChild(PsiElement child, List<PsiElement> allChildList) {
//        allChildList.addAll(PsiTreeUtil.getChildrenOfTypeAsList(child, PsiJavaToken.class));
//        for (PsiElement element : child.getChildren()) {
//            getChild(element, allChildList);
//        }
//    }
//
//    private static boolean isContainsChinese(String str) {
//        if (StringUtils.isBlank(str)) {
//            return false;
//        }
//        Pattern pattern = Pattern.compile("[\u4e00-\u9fa5]");
//        Matcher matcher = pattern.matcher(str);
//        return matcher.find();
//    }
//}
