#!/bin/sh
npm install --global mjml;
mjml email_template.mjml -o ../resources/templates/emails/email_template.html;